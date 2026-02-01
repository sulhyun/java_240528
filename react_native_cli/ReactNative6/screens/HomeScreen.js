import React, { useContext } from "react";
import { Button, TextInput, View } from "react-native";
import LogContext from "../contexts/LogContext";

function HomeScreen({navigation}) {
  const {text, setText} = useContext(LogContext);
  return(
    <View>
      <Button 
        title="Detail 이동"
        onPress={() => {navigation.navigate('Detail')}} 
      />
      <TextInput
        value={text}
        onChangeText={setText}
        placeholder="텍스트를 입력하세요..."
      />
    </View>
  );
}

export default HomeScreen;