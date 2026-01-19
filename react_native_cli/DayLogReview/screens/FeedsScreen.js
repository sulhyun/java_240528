import { Text, View, Button } from "react-native";

function FeedsScreen({navigation}) {
  return(
    <View>
      <Text>Feed</Text>
      <Button title="Write 이동" onPress={() => navigation.push('Write',{name: '홍길동'})} />
    </View>
  );
};

export default FeedsScreen;