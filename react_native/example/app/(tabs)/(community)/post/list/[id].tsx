import { useLocalSearchParams, useRouter } from "expo-router";
import { useEffect, useState } from "react";
import { FlatList, StyleSheet, Text, TouchableOpacity, View } from "react-native";

type Post = {
  po_num: number, 
  po_title: string, 
  po_content: string, 
  po_me_id: string, 
  po_co_num: number, 
  po_date: Date, 
  po_view: number, 
  po_report: number,
}

export default function PostList() {
  const {id} = useLocalSearchParams();
  const [list, setList] = useState<Post[]>([]);
  const router = useRouter();

  useEffect(() => {
  fetch('http://192.168.0.222:8080/spring_react/spring/rn/post/list/' + id)
    .then((res) => res.json())
    .then((res) => {
      setList(res.list);
    })
  }, []);

  const renderItem = ({item} : {item : Post}) => {
    return(
      <View>
        <TouchableOpacity style={styles.row} onPress={() => router.push({pathname: "/post/detail/[id]", params: {id : item.po_num}})}>
          <Text style={[styles.cell, styles.idCol]}>{item.po_num}</Text>
          <Text style={[styles.cell, styles.titleCol]} numberOfLines={1}>{item.po_title}</Text>
          <Text style={[styles.cell, styles.writerCol]}>{item.po_me_id}</Text>
          <Text style={[styles.cell, styles.viewCol]}>{item.po_view}</Text>
        </TouchableOpacity>
      </View>
    )
  }
  return(
    <View style={styles.container}>
      <View style={styles.titleWrapper}>
        <Text style={styles.titleText}>커뮤니티</Text>
      </View>
      <View style={styles.header}>
        <Text style={[styles.headerText, styles.idCol]}>번호</Text>
        <Text style={[styles.headerText, styles.titleCol]}>제목</Text>
        <Text style={[styles.headerText, styles.writerCol]}>작성자</Text>
        <Text style={[styles.headerText, styles.viewCol]}>조회</Text>
      </View>
      <FlatList
        data={list}
        renderItem={renderItem}
        keyExtractor={(item) => item.po_num.toString()}
      />
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#fff', paddingHorizontal: 10, paddingVertical: 50 },
  titleWrapper: { paddingVertical: 20, flexDirection: 'row' },
  titleText: { fontSize: 25, fontWeight: 'bold', flex: 1 },
  writeButton: { backgroundColor: 'skyblue', paddingVertical: 6, paddingHorizontal: 12, borderRadius: 15 },
  writeButtonText: { color: '#fff', fontWeight: 'bold', fontSize: 14 },
  header: { flexDirection: 'row', backgroundColor: '#f1f3f5', paddingVertical: 12, borderBottomWidth: 2, borderBottomColor: '#dee2e6', borderTopWidth: 1, borderTopColor: '#adb5bd' },
  row: { flexDirection: 'row', paddingVertical: 15, borderBottomWidth: 1, borderBottomColor: '#e9ecef', alignItems: 'center' },
  headerText: { fontWeight: 'bold', textAlign: 'center', fontSize: 14, color: '#495057' },
  cell: { textAlign: 'center', fontSize: 14, color: '#333' },
  idCol: { flex: 1 },
  titleCol: { flex: 4 },
  writerCol: { flex: 2 },
  viewCol: { flex: 1.2 },
})