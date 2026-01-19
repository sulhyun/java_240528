import { Pressable, StyleSheet, Text, View } from "react-native";
import Icon from 'react-native-vector-icons/MaterialIcons';
import { useNavigation } from "@react-navigation/native";

function WriteHeader() {
  const navigation = useNavigation();

  const onGoBack = () => {
    navigation.pop();
  }
  return(
    <View style={styles.block}>
      <View style={styles.iconButtonWrapper}>
        <Pressable
          style={styles.iconButton}
          onPress={onGoBack}
          android_ripple={{color: '#ededed'}}
        >
          <Icon name="arrow-back" size={24} color="#424242" />
        </Pressable>
      </View>
      <View style={styles.buttons}>
        <View style={[styles.iconButtonWrapper, styles.marginRight]}>
          <Pressable
            style={styles.iconButton}
            android_ripple={{color: '#ededed'}}
          >
            <Icon name="delete-forever" size={24} color="#424242" />
          </Pressable>
        </View>
        <View style={styles.iconButtonWrapper}>
          <Pressable
            style={styles.iconButton}
            android_ripple={{color: '#ededed'}}
          >
            <Icon name="check" size={24} color="#424242" />
          </Pressable>
        </View>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  block: {
    height: 45,
    paddingHorizontal: 8,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
  },
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
  buttons: {
    flexDirection: 'row',
    alignItems: 'center',
  },
  marginRight: {
    marginRight: 8,
  },
});

export default WriteHeader;