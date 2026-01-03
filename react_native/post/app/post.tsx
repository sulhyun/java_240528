import PostList from "@/components/postList";
import { Link } from "expo-router";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";
import { usePosts } from "./_layout";

export default function Post(){
  const { postList } = usePosts();

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
  }
})