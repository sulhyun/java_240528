import React, { useContext } from "react";
import { Text, View } from "react-native";
import LogContext from "../contexts/LogContext";

function DetailScreen() {
  const {text} = useContext(LogContext);
  return(
    <View>
      <Text>{text}</Text>
    </View>
  );
}

export default DetailScreen;