import { useLocalSearchParams } from "expo-router";
import { useEffect, useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

type Post = {
  po_num: number, 
  po_title: string, 
  po_content: string, 
  po_me_id: string, 
  po_co_num: number, 
  po_date: Date, 
  po_view: number, 
  po_report: number
}
export default function PostDetail() {
  const {id} = useLocalSearchParams();
  const [post, setPost] = useState<Post[]>([]);

  useEffect(() => {
    fetch('http://192.168.0.222:8080/spring_react/spring/rn/post/detail/' + id)
  })
  return (
    <View style={styles.container}>
      <View style={styles.contentWrapper}>
        <Text style={styles.title}>제목</Text>
        <View style={styles.infoRow}>
          <Text style={styles.writer}>작성자: 홍길동</Text>
          <Text style={styles.view}>조회수: 1</Text>
        </View>
        <View style={styles.divider} />
        <Text style={styles.content}>내용</Text>
      </View>
      <View style={styles.headerRow}>
        <TouchableOpacity style={[styles.btn, styles.btnDelColor]}>
          <Text style={styles.deleteText}>삭제</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.btn, styles.btnUpdateColor]}>
          <Text style={styles.deleteText}>수정</Text>
        </TouchableOpacity>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: '#fff', paddingHorizontal: 15, paddingTop: 60, paddingBottom: 20},
  headerRow: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  deleteText: { fontSize: 16, color: 'white', fontWeight: 'bold', textAlign: 'center' },
  btn: { flex: 1, paddingHorizontal: 10, paddingVertical: 15 },
  btnDelColor: {backgroundColor: 'salmon'},
  btnUpdateColor: {backgroundColor: 'lightgreen'},
  contentWrapper: { flex: 1 },
  title: { fontSize: 24, fontWeight: 'bold', marginBottom: 10 },
  infoRow: { flexDirection: 'row', justifyContent: 'space-between', marginBottom: 20 },
  writer: { color: '#666' },
  view: { color: '#666' },
  divider: { height: 1, backgroundColor: '#eee', marginBottom: 20 },
  content: { fontSize: 16, lineHeight: 24 },
});