import React from "react";
import { Text, View } from "react-native";

function Greeting({name="홍길동"}) {
  return(
    <View>
      <Text>안녕하세요 {name}</Text>
    </View>
  );
};

export default Greeting;