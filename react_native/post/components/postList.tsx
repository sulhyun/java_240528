import { FlatList, StyleSheet, Text, TouchableOpacity, View } from 'react-native';

type Post = {
  id : number;
  title : string;
  writer : string;
  content : string;
  view : number;
}

interface PostListProps {
  postList: Post[];
}

function PostList({postList} : PostListProps) {

   const renderItem = ({item} : {item : Post}) => {
    return(
      <View>
        <TouchableOpacity style={styles.row}>
          <Text style={[styles.cell, styles.idCol]}>{item.id}</Text>
          <Text style={[styles.cell, styles.titleCol]} numberOfLines={1}>{item.title}</Text>
          <Text style={[styles.cell, styles.writerCol]}>{item.writer}</Text>
          <Text style={[styles.cell, styles.viewCol]}>{item.view}</Text>
        </TouchableOpacity>
      </View>
    )
  }
  return(
    <>
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
    </>
  )
}

export default PostList;

const styles = StyleSheet.create({
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
});