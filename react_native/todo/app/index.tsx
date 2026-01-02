import { useState } from 'react';
import { FlatList, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

type Todo = {
  id: number,
  text: string
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
      text : text
    }
    setTodoList([...todoList, tmp]);
    setText("");
    setId((prev) => prev + 1);
  }

  // 조회
  const randerItem = ({item} : {item : Todo}) => {
    return (
      <View style={styles.list}>
        <TouchableOpacity>
          <Text style={styles.listText}>{item.text}</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.btn, styles.btnUpdateColor]} onPress={() => updateTodo(item)}>
          <Text style={styles.buttonText}>수정</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.btn, styles.btnDelColor]} onPress={() => delTodo(item.id)}>
          <Text style={styles.buttonText}>삭제</Text>
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

  return (
    <>
      <View style={styles.contains}>
        <Text style={styles.title}>My Todo List</Text>
        <View style={styles.inputContainer}>
          <TextInput style={styles.input} value={text} onChangeText={onChangeText} />
          {
            !flag ? (
            <TouchableOpacity style={styles.button} onPress={addTodo}>
              <Text style={styles.buttonText}>추가</Text>
            </TouchableOpacity> 
            ) : (
            <TouchableOpacity style={styles.button} onPress={saveTodo}>
              <Text style={styles.buttonText}>저장</Text>
            </TouchableOpacity>
            )
          }
        </View>
        <View>
          <FlatList data={todoList} renderItem={randerItem} keyExtractor={(item) => item.id.toString()}></FlatList>
        </View>
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  contains : {
    backgroundColor: 'white',
    flex: 1,
    padding: 15,
  },
  title : {
    fontSize: 35,
  },
  input : {
    padding: 10, 
    flex: 1,
  },
  button : {
    backgroundColor: 'lightblue',
    justifyContent: 'center',
    paddingHorizontal: 20,
  },
  buttonText : {
    fontWeight: 'bold',
  },
  inputContainer : {
    flexDirection: 'row',
    borderWidth: 1,
    borderRadius: 8,
    overflow: 'hidden',
    marginVertical: 15,
  },
  list : {
    flexDirection: 'row',
    marginBottom: 10,
  },
  listText : {
    flex: 1,
    fontSize: 25,
  },
  btn : {
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
  }
})