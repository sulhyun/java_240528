import { useState } from 'react';
import { FlatList, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

type Todo = {
  id : number,
  text : string,
  done : boolean
}

export default function Index() {
  const [text, setText] = useState("");
  const [id, setId] = useState(1);
  const [list, setList] = useState<Todo[]>([]);
  const [flag, setFlag] = useState(false);
  const [tmp, setTmp] = useState(-1);

  const onChangeText = (content: string) => (
    setText(content)
  )
 
  const addTodo = () => {
    if(text.trim() === "") {
      return;
    }
    const tmp = {
      id,
      text,
      done: false
    };
    setList((prev) => [tmp, ...prev]);
    setText("");
    setId((prev) => (prev + 1));
  }

  const delTodo = (id: number) => {
    setList((prev) => (prev.filter((item) => id !== item.id)));
  }

  const updateTodo = (item: Todo) => {
    setText(item.text);
    setTmp(item.id);
    setFlag(true);
  }

  const saveTodo = () => {
    setList((prev) => (prev.map((item) => item.id === tmp ? {...item, text: text} : item)));
    setText("");
    setTmp(-1);
    setFlag(false);
  }

  const toggleTodo = (id : number) => {
    setList((prev) => prev.map((item) => item.id === id ? {...item, done : !item.done} : item));
  }

  const renderItem = ({item} : {item : Todo}) => {
    return(
      <View style={ styles.listContainer }>
        <TouchableOpacity style={ styles.textBtn } onPress={() => toggleTodo(item.id)}>
          <Text style={[ styles.listText, item.done ? styles.lineThrough : "" ]} >{item.text}</Text>
        </TouchableOpacity>
        <View style={ styles.btnGroup }>
          <TouchableOpacity style={ styles.listBtn } onPress={() => updateTodo(item)}>
            <Text style={[ styles.btnText, styles.updateColor ]}>수정</Text>
          </TouchableOpacity>
          <TouchableOpacity style={ styles.listBtn } onPress={() => delTodo(item.id)}>
            <Text style={[ styles.btnText, styles.delColor ]}>삭제</Text>
          </TouchableOpacity>
        </View>
      </View>
    )
  }
  return (
    <View style={ styles.container }>
      <Text style={ styles.titleText }>My Todo List</Text>
      <View style={ styles.inputContainer }>  
        <TextInput style={ styles.input } value={text} onChangeText={onChangeText}></TextInput>
        {
          !flag ?
          <TouchableOpacity style={ styles.inputBtn } onPress={addTodo}>
            <Text style={ styles.btnText }>추가</Text>
          </TouchableOpacity>
          :
          <TouchableOpacity style={ styles.inputBtn } onPress={saveTodo}>
            <Text style={ styles.btnText }>저장</Text>
          </TouchableOpacity>
        }
      </View>
        <FlatList data={list} renderItem={renderItem} keyExtractor={(item) => item.id.toString()} />
    </View>
  );
}

const styles = StyleSheet.create({
  container : { flex: 1, backgroundColor: "white", padding: 20, paddingVertical: 70 },
  titleText : { fontSize: 25 },
  inputContainer : { flexDirection: "row", borderWidth: 1, borderRadius: 8, marginVertical: 10, overflow: "hidden" },
  input : { flex: 1 },
  inputBtn : { justifyContent: "center", paddingHorizontal: 20, backgroundColor: 'plum' },
  btnText : { fontWeight: '600', fontSize: 16 },
  listContainer : { flexDirection: "row", paddingVertical: 10 },
  btnGroup : { flexDirection: "row" },
  listBtn : { justifyContent: "center", paddingHorizontal: 4 },
  delColor : { color: "salmon" },
  updateColor : { color : "lightgreen" },
  textBtn : { flex: 1 },
  listText : { fontSize: 16 },
  lineThrough : { textDecorationLine: "line-through", color: "gray" }
});