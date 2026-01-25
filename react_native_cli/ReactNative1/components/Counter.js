import React, { useState } from "react";
import { Button, StyleSheet, Text, View } from "react-native";

function Counter() {
  const [count, setCount] = useState(0);

  const move = (num) => setCount(count + num);
  return(
    <View style={styles.wrapper}>
      <View style={styles.numberArea}>
        <Text style={styles.number}>{count}</Text>
      </View>
      <Button title="+1" onPress={() => move(1)} />
      <Button title="-1" onPress={() => move(-1)} />
    </View>
  );
};

const styles = StyleSheet.create({
  wrapper: {
    flex: 1,
  },
  numberArea: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  number: {
    fontSize: 72,
    fontWeight: 'bold',
  },
});

export default Counter;