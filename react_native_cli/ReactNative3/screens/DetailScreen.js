import React from "react";
import { Button, StyleSheet, Text, View } from "react-native";

/*
  route 객체가 들고 있는 값
  "key": "Detail-DfkNvfwrvj2Zq4JeM1Hgl"
  "name": "Detail"
  "params": {id: 1}
*/
function DetailScreen({route, navigation}) {
  return(
    <View style={styles.block}>
      <Text style={styles.text}>Detail {route.params.id}</Text>
      <Button 
        title="다음"
        onPress={() => navigation.push('Detail', {id: route.params.id + 1})}
      />
      <Button title="뒤로가기" onPress={() => navigation.pop()} />
      <Button title="처음으로" onPress={() => navigation.popToTop()} />
    </View>
  );
}

const styles = StyleSheet.create({
  block: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    fontSize: 48,
  },
});

export default DetailScreen;