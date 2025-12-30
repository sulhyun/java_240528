import { View, Text, Image, ScrollView } from 'react-native';

const logo = require('./assets/adaptive-icon.png');

export default function App() {
  return (
    <View style={{ backgroundColor : 'plum', flex : 1, padding : 60}}>
      <ScrollView>
        <Image source={logo} style={{ width : 300, height : 300 }} />
        <Text>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent
          vehicula magna at magna dictum, in sagittis libero ullamcorper. Donec
          finibus libero at ex facilisis, non convallis felis faucibus. Nunc
          venenatis, odio nec suscipit efficitur, dui lorem interdum mi, vel
          suscipit nunc lorem nec libero. Suspendisse potenti. Integer rhoncus,
          nisi a convallis feugiat, ligula ex pellentesque libero, non posuere
          erat leo vitae erat. Maecenas vel orci vitae metus aliquet fermentum.
          Proin at justo eget lacus semper hendrerit.
        </Text>
        <Image source={logo} style={{ width : 300, height : 300 }} />
      </ScrollView>
    </View>
  );
}

