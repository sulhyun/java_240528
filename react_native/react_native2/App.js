import { View, Text } from 'react-native';

export default function App() {
  return (
    <View style={{ backgroundColor : 'plum', flex : 1, padding : 60 }}>
      <Text>Hello World</Text>
      <Text>
        <Text style={{ color : 'white' }}>Hello</Text>
        World
      </Text>
    </View>
  );
}