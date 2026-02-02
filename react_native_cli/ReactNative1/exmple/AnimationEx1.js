import React, { useEffect, useRef, useState } from "react";
import { Animated, Button, StyleSheet, View } from "react-native";

// 서서히 나타나고, 서서히 사라지기
function AnimationEx1() {
  const animation = useRef(new Animated.Value(1)).current
  const [hidden, setHidden] = useState(false);
  useEffect(() => {
    Animated.timing(animation, {
      toValue: hidden ? 0 : 1,
      useNativeDriver: true,
    }).start();
  }, [hidden, animation])
  return(
    <View>
        <Animated.View style={[styles.rectangle, {opacity: animation}]} />
        <Button title="토글" onPress={() => setHidden(!hidden)} />
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

export default AnimationEx1;