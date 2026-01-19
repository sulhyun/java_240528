import React from "react";
import { StyleSheet, View, Pressable } from "react-native";

function TransparentCircleButton({name, color, hasMarginRight, onPress}) {

  return(
    <View style={[styles.iconButtonWrapper, styles.marginRight]}>
      <Pressable
        style={styles.iconButton}
        android_ripple={{color: '#ededed'}}
      >
        <Icon name="delete-forever" size={24} color="#424242" />
      </Pressable>
    </View>
  );
};

const styles = StyleSheet.create({
  iconButtonWrapper: {
    width: 32,
    height: 32,
    borderRadius: 16,
    overflow: 'hidden',
  },
  iconButton: {
    alignItems: 'center',
    justifyContent: 'center',
    width: 32,
    height: 32,
    borderRadius: 16,
  },
  marginRight: {
    marginRight: 8,
  }
});

export default TransparentCircleButton;