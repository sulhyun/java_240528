import PostList from "@/components/postList";
import { Link } from "expo-router";
import { useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

type Post = {
  id : number;
  title : string;
  writer : string;
  content : string;
  view : number;
}

export default function Post(){
  const [postList, setPostList] = useState<Post[]>([
    {
      id : 0,
      title : '공지사항',
      writer : 'Admin',
      content : '공지사항',
      view : 0
    }
  ]);

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
      <PostList postList={postList} />
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    paddingHorizontal: 10,
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
  }
})