import { Pressable, StyleSheet, View } from "react-native";
import Icon from 'react-native-vector-icons/MaterialIcons';
import { useNavigation } from "@react-navigation/native";

function FloatingWriteButton() {
  const navigation = useNavigation();

  const onPress = () => {
    navigation.navigate('Write');
  };
  return(
    <View style={styles.wrapper}>
      <Pressable
        style={styles.button}
        android_ripple={{color: 'white'}}
        onPress={onPress}
      >
        <Icon name="add" size={24} style={styles.icon} />
      </Pressable>
    </View>
  );
};

const styles = StyleSheet.create({
  wrapper: {
    position: 'absolute',
    right: 16,
    bottom: 16,
    width: 56,
    height: 56,
    borderRadius: 28,
    elevation: 5,
    overflow: 'hidden',
  },
  button: {
    width: 56,
    height: 56,
    borderRadius: 28,
    backgroundColor: '#009688',
    justifyContent: 'center',
    alignItems: 'center',
  },
  icon: {
    color: 'white',
  }
});

export default FloatingWriteButton;