import { useState } from 'react';
import { FlatList, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

type Todo = {
  id: number,
  text: string,
  done: boolean
}

export default function Index() {
  const [text, setText] = useState("");
  const [todoList, setTodoList] = useState<Todo[]>([]);
  const [id, setId] = useState(1);
  const [flag, setFlag] = useState(false);
  const [tmp, setTmp] = useState(-1);

  const onChangeText = (content: string) => {
    setText(content);
  }

  // 추가
  const addTodo = () => {
    if(text === '') {
      return;
    }
    const tmp = {
      id : id,
      text : text,
      done : false
    }
    setTodoList([...todoList, tmp]);
    setText("");
    setId((prev) => prev + 1);
  }

  // 조회
  const renderItem = ({item} : {item : Todo}) => {
    return (
      <View style={styles.todoItem}>
        <TouchableOpacity style={styles.todoTextWrapper} onPress={() => toggleTodo(item.id)}>
          <Text style={[styles.todoText, item.done ? styles.doneText : '']}>{item.text}</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.btnTodo, styles.btnUpdateColor]} onPress={() => updateTodo(item)}>
          <Text style={styles.btnLabel}>수정</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.btnTodo, styles.btnDelColor]} onPress={() => delTodo(item.id)}>
          <Text style={styles.btnLabel}>삭제</Text>
        </TouchableOpacity>
      </View>
    )
  }

  // 삭제
  const delTodo = (id : number) => {
    setTodoList(todoList.filter((item) => id !== item.id));
  }

  // 수정
  const updateTodo = (item : Todo) => {
    setText(item.text);
    setFlag(true);
    setTmp(item.id);
  }

  const saveTodo = () => {
    if(text === '') {
      setFlag(false);
      return;
    }
    setTodoList(todoList.map((item) => {
      return (
        item.id === tmp ? {...item, text: text} : item
      )
    }))
    setText("");
    setFlag(false);
    setTmp(-1);
  }

  // 토글
  const toggleTodo = (id : number) => {
    setTodoList(todoList.map((item) => {
      return(
        item.id === id ? {...item, done: !item.done} : item
      )
    }))
  }

  return (
    <>
      <View style={styles.container}>
        <Text style={styles.title}>My Todo List</Text>
        <View style={styles.formContainer}>
          <TextInput style={styles.textInput} value={text} onChangeText={onChangeText} />
          {
            !flag ? (
            <TouchableOpacity style={styles.btnInput} onPress={addTodo}>
              <Text style={styles.btnLabel}>추가</Text>
            </TouchableOpacity> 
            ) : (
            <TouchableOpacity style={styles.btnInput} onPress={saveTodo}>
              <Text style={styles.btnLabel}>저장</Text>
            </TouchableOpacity>
            )
          }
        </View>
        <View>
          <FlatList data={todoList} renderItem={renderItem} keyExtractor={(item) => item.id.toString()}></FlatList>
        </View>
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  container : {
    backgroundColor: 'white',
    flex: 1,
    padding: 15,
    paddingTop: 70,
  },
  title : {
    fontSize: 35,
  },
  formContainer : {
    flexDirection: 'row',
    borderWidth: 1,
    borderRadius: 8,
    marginVertical: 15,
    overflow: 'hidden',
  },
  textInput : {
    padding: 10, 
    flex: 1,
  },
  btnInput : {
    backgroundColor: 'lightblue',
    justifyContent: 'center',
    paddingHorizontal: 20,
  },
  btnLabel : {
    fontWeight: 'bold',
  },
  todoItem : {
    flexDirection: 'row',
    marginBottom: 10,
  },
  todoTextWrapper : {
    flex: 1,
  },
  todoText : {
    fontSize: 22,
  },
  btnTodo: {
    justifyContent: 'center',
    paddingHorizontal: 15,
    paddingVertical: 10,
    borderRadius: 5,
  },
  btnDelColor : {
    backgroundColor: 'salmon',
  },
  btnUpdateColor : {
    backgroundColor: 'lightgreen',
  },
  doneText : {
    textDecorationLine: 'line-through',
    color: 'gray',
  }
})