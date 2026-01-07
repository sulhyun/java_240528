import { useRouter } from 'expo-router';
import { useEffect, useState } from 'react';
import { FlatList, StyleSheet, Text, TouchableOpacity, View } from 'react-native';

type Community = {
  co_num : number,
  co_name : string
}

export default function Index() {
  const [list, setList] = useState<Community[]>([]);
  const router = useRouter();

  useEffect(() => {
    fetch('http://192.168.0.222:8080/spring_react/spring/rn/community/list')
      .then((res) => res.json())
      .then((res) => {
        setList(res);
      })
  }, []);
  
  const renderItem = ({item} : {item : Community}) => {
    return (
      <View>
        <TouchableOpacity onPress={() => router.push({pathname: "/post/[id]", params: {id : item.co_num}})}>
          <Text>{item.co_name}</Text>
        </TouchableOpacity>
      </View>
    )
  }

  return (
    <View style={ styles.container }>
      <FlatList data={list} renderItem={renderItem} keyExtractor={(item) => item.co_num.toString()} contentContainerStyle={ styles.listContainer } />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, alignItems: "center", justifyContent: "center", backgroundColor: "white" },
  listContainer: { flexGrow: 1, justifyContent: 'center' }
});