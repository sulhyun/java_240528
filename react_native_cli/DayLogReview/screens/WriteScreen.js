import { Text, View } from "react-native";

function WriteScreen({route}) {
  return(
    <View>
      <Text>Write {route.params.name}</Text>
    </View>
  );
};

export default WriteScreen;