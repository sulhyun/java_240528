import { View, Text, Image, ImageBackground } from 'react-native'

const logo = require('./assets/adaptive-icon.png');
export default function App() {
  return (
    /*
    <View style={{ backgroundColor : 'plum', flex : 1, padding : 60 }}>
      <Image source={logo} style={{ width : 300, height : 300 }} />
      <Image source={{ uri : 'https://picsum.photos/300' }} style={{ width : 300, height : 300 }} />
    </View>
    */
    <View style={{ backgroundColor : 'plum', flex : 1, padding : 60 }}>
      <ImageBackground source={logo} style={{ flex : 1 }}>
        <Text>Hello World</Text>
      </ImageBackground>
    </View>
  );
}