import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

export default function PostDetail() {
  
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