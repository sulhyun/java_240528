import { Link } from "expo-router";
import { FlatList, StyleSheet, Text, TouchableOpacity, View } from "react-native";
import { usePosts } from "./_layout";

type Post = { 
  id: number; 
  title: string; 
  writer: string; 
  content: string;
  view: number; 
  };
  
export default function Post(){
  const { postList } = usePosts();

  const renderItem = ({item} : {item : Post}) => {
      return(
        <View>
          <Link href={{pathname: "/postDetail/[id]", params: {id: item.id}}} asChild>
            <TouchableOpacity style={styles.row}>
              <Text style={[styles.cell, styles.idCol]}>{item.id}</Text>
              <Text style={[styles.cell, styles.titleCol]} numberOfLines={1}>{item.title}</Text>
              <Text style={[styles.cell, styles.writerCol]}>{item.writer}</Text>
              <Text style={[styles.cell, styles.viewCol]}>{item.view}</Text>
            </TouchableOpacity>
          </Link>
        </View>
      )
    }
  return(
    <View style={styles.container}>
      <View style={styles.titleWrapper}>
        <Text style={styles.titleText}>커뮤니티</Text>
        <Link href="/postInsert" asChild>
          <TouchableOpacity style={styles.writeButton}>
            <Text style={styles.writeButtonText}>게시글 작성</Text>
          </TouchableOpacity>
        </Link>
      </View>
      <View style={styles.header}>
        <Text style={[styles.headerText, styles.idCol]}>번호</Text>
        <Text style={[styles.headerText, styles.titleCol]}>제목</Text>
        <Text style={[styles.headerText, styles.writerCol]}>작성자</Text>
        <Text style={[styles.headerText, styles.viewCol]}>조회</Text>
      </View>
      <FlatList
        data={postList}
        renderItem={renderItem}
        keyExtractor={(item) => item.id.toString()}
            />
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    paddingHorizontal: 10,
    paddingVertical: 50,
  },
  titleWrapper : {
    paddingVertical: 20,
    flexDirection: 'row'
  },
  titleText : {
    fontSize: 25,
    fontWeight: 'bold',
    flex: 1,
  },
  writeButton: {
    backgroundColor: 'skyblue',
    paddingVertical: 6,
    paddingHorizontal: 12,
    borderRadius: 15,
  },
  writeButtonText: {
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 14,
  },
  header: {
    flexDirection: 'row',
    backgroundColor: '#f1f3f5',
    paddingVertical: 12,
    borderBottomWidth: 2,
    borderBottomColor: '#dee2e6',
    borderTopWidth: 1,
    borderTopColor: '#adb5bd',
  },
  row: {
    flexDirection: 'row',
    paddingVertical: 15,
    borderBottomWidth: 1,
    borderBottomColor: '#e9ecef',
    alignItems: 'center',
  },
  headerText: {
    fontWeight: 'bold',
    textAlign: 'center',
    fontSize: 14,
    color: '#495057',
  },
  cell: {
    textAlign: 'center',
    fontSize: 14,
    color: '#333',
  },
  idCol: { flex: 1 },
  titleCol: { flex: 4 },
  writerCol: { flex: 2 },
  viewCol: { flex: 1.2 },
})