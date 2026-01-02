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

  const onChangeText = (content: string) => {
    setText(content);
  }

  // 추가
  const addTodo = () => {
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
        <Text style={styles.listText}>{item.text}</Text>
        <TouchableOpacity style={styles.delBtn} onPress={() => delTodo(item.id)}>
          <Text>삭제</Text>
        </TouchableOpacity>
      </View>
    )
  }

  // 삭제
  const delTodo = (id : number) => {
    setTodoList(todoList.filter((item) => id !== item.id));
  }

  return (
    <>
      <View style={styles.contains}>
        <Text style={styles.title}>My Todo</Text>
        <View style={styles.inputContainer}>
          <TextInput style={styles.input} value={text} onChangeText={onChangeText} />
          <TouchableOpacity style={styles.button} onPress={addTodo}>
            <Text style={styles.buttonText}>추가</Text>
          </TouchableOpacity>
        </View>
        <View>
          <Text>{text}</Text>
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
    fontWeight: 'bold',
    fontSize: 40,
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
  },
  list : {
    flexDirection: 'row',
    marginBottom: 4,
  },
  listText : {
    flex: 1,
    fontSize: 25,
    borderBottomWidth: 1,
    borderColor: 'gray',
  },
  delBtn : {
    borderWidth: 1,
    backgroundColor: 'salmon',
    padding: 5,
    borderRadius: 5,
  }
})