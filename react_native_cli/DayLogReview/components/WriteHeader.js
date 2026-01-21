import React from "react";
import { StyleSheet, View } from "react-native";
import { useNavigation } from "@react-navigation/native";
import TransparentCircleButton from './TransparentCircleButton';

function WriteHeader({onSave, onDelete, isEditing}) {
  const navigation = useNavigation();

  const onGoBack = () => {
    navigation.pop();
  };
  return(
    <View style={styles.block}>
      <TransparentCircleButton 
        name="arrow-back" 
        color="#424242" 
        onPress={onGoBack} 
      />
      <View style={styles.buttons}>
        {isEditing && (
          <TransparentCircleButton 
            name="delete-forever" 
            color="#ef5350" 
            hasMarginRight 
            onPress={onDelete} 
          />
        )}
        <TransparentCircleButton 
          name="check" 
          color="#009688" 
          onPress={onSave} 
        />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  block: {
    height: 45,
    paddingHorizontal: 8,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
  },
  buttons: {
    flexDirection: 'row',
    alignItems: 'center',
  },
});

export default WriteHeader;