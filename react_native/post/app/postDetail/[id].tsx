import { useLocalSearchParams } from "expo-router";
import { useEffect } from "react";
import { StyleSheet, Text, View } from "react-native";
import { usePosts } from "../_layout";

export default function PostDetail() {
  const { id } = useLocalSearchParams();
  const { postList, updateView } = usePosts(); 

  const post = postList.find((item) => item.id === Number(id));

  useEffect(() => {
    if (id) {
      updateView(Number(id));
    }
  }, []);

  if (!post) {
    return (
      <View style={styles.container}>
        <Text>게시글을 찾을 수 없습니다.</Text>
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <View style={styles.contentWrapper}>
        <Text style={styles.title}>{post.title}</Text>
        <View style={styles.infoRow}>
          <Text style={styles.writer}>작성자: {post.writer}</Text>
          <Text style={styles.view}>조회수: {post.view}</Text>
        </View>
        <View style={styles.divider} />
        <Text style={styles.content}>{post.content}</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#fff', paddingHorizontal: 10, paddingVertical: 70 },
  contentWrapper: { flex: 1 },
  title: { fontSize: 24, fontWeight: 'bold', marginBottom: 10 },
  infoRow: { flexDirection: 'row', justifyContent: 'space-between', marginBottom: 20 },
  writer: { color: '#666' },
  view: { color: '#666' },
  divider: { height: 1, backgroundColor: '#eee', marginBottom: 20 },
  content: { fontSize: 16, lineHeight: 24 },
});