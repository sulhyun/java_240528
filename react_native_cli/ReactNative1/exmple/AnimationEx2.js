import React, { useEffect, useRef, useState } from "react";
import { Animated, Button, StyleSheet, View } from "react-native";

// 좌우로 움직이기
function AnimationEx2() {
  const animation = useRef(new Animated.Value(1)).current
  const [enabled, setEnabled] = useState(false);
  useEffect(() => {
    Animated.timing(animation, {
      toValue: enabled ? 150 : 0,
      useNativeDriver: true,
    }).start();
  }, [enabled, animation])
  return(
    <View>
        <Animated.View style={[styles.rectangle, {transform: [{translateX: animation}]}]} />
        <Button title="토글" onPress={() => setEnabled(!enabled)} />
    </View>
  );
}

const styles = StyleSheet.create({
  rectangle: {
    width: 100,
    height: 100,
    backgroundColor: 'black',
  },
});

export default AnimationEx2;