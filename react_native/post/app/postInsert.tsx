import { useRouter } from "expo-router";
import { useState } from "react";
import { ScrollView, StyleSheet, Text, TextInput, TouchableOpacity, View } from "react-native";
import { usePosts } from "./_layout";

export default function PostInsert() {
  const [title, setTitle] = useState("");
  const [writer, setWriter] = useState("");
  const [content, setContent] = useState("");
  const { addPost } = usePosts();
  const router = useRouter();

  const savePost = () => {
    if(title.trim() === "" || writer.trim() === "" || content.trim() === "") {
      return;
    }
    addPost({
      title,
      writer,
      content,
      view: 0
    });
    router.back();
  }
  return (
    <ScrollView style={styles.container}>
      <View style={styles.titleWrapper}>
        <Text style={styles.titleText}>게시글 작성</Text>
      </View>
      <View style={styles.inputContainer}>
        <Text style={styles.label}>제목</Text>
        <TextInput
          style={styles.input}
          value={title}
          onChangeText={setTitle}
        />
        <Text style={styles.label}>작성자</Text>
        <TextInput
          style={styles.input}
          value={writer}
          onChangeText={setWriter}
        />
        <Text style={styles.label}>내용</Text>
        <TextInput
          style={[styles.input, styles.contentInput]}
          value={content}
          onChangeText={setContent}
          multiline
          textAlignVertical="top"
        />
        <TouchableOpacity style={styles.saveButton} onPress={savePost}>
          <Text style={styles.saveButtonText}>저장하기</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
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
  },
  titleText : {
    fontSize: 25,
    fontWeight: 'bold',
  },
  inputContainer: {
    gap: 10,
  },
  label: {
    fontSize: 16,
    fontWeight: '600',
    color: '#555',
    marginBottom: 5,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 8,
    padding: 12,
    fontSize: 16,
  },
  contentInput: {
    height: 200,
  },
  saveButton: {
    backgroundColor: '#4dabf7',
    paddingVertical: 15,
    borderRadius: 8,
    alignItems: 'center',
    marginTop: 20,
    marginBottom: 40,
  },
  saveButtonText: {
    color: '#fff',
    fontSize: 18,
    fontWeight: 'bold',
  },
})