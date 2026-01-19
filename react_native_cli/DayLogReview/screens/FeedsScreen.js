import { useContext } from "react";
import { Text, View, Button } from "react-native";
import LogContext from "../contexts/LogContext";

function FeedsScreen({navigation}) {
  const value = useContext(LogContext);

  return(
    <View>
      <Text>Feed</Text>
      <Button title="Write 이동" onPress={() => navigation.push('Write',{name: '홍길동'})} />
      <Text>{value}</Text>
    </View>
  );
};

export default FeedsScreen;