import React, { useContext, useState } from "react";
import { KeyboardAvoidingView, Platform, StyleSheet } from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import WriteHeader from "../components/WriteHeader";
import WriteEditor from "../components/WirteEditor";
import LogContext from "../contexts/LogContext";
import { useNavigation } from "@react-navigation/native";

function WriteScreen() {
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");
  const {onCreate} = useContext(LogContext);
  const navigation = useNavigation();

  const onSave = () => {
    onCreate({
      title,
      body,
      date: new Date().toISOString(),
    });
    navigation.pop();
  };
  return(
    <SafeAreaView style={styles.block}>
      <KeyboardAvoidingView
        style={styles.avoidingView}
        behavior={Platform.select({ios: 'padding'})}
      >
        <WriteHeader onSave={onSave} />
        <WriteEditor 
          titie={title} 
          body={body} 
          onChangeTitle={setTitle} 
          onChangeBody={setBody} 
        />
      </KeyboardAvoidingView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  block: {
    flex: 1,
    backgroundColor: 'white',
  },
  avoidingView: {
    flex: 1,
  },
});

export default WriteScreen;