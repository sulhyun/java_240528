import { View, Text, StyleSheet } from 'react-native';
import Greet from './components/greet';

export default function App() {
  return (
    <View style={styles.container}>
      <View style={[styles.box, styles.lightBlueBackground]}>
        <Text style={styles.font}>Light Blue Box</Text>
      </View>
      <View style={[styles.box, styles.lightGreenBackground]}>
        <Text style={styles.font}>Light Green Box</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container : {
    backgroundColor : 'plum',
    flex : 1,
    padding : 60
  },
  box : {
    width : 300,
    height : 300,
    marginBottom : 20
  },
  lightBlueBackground : {
    backgroundColor : 'lightblue'
  },
  lightGreenBackground : {
    backgroundColor : 'lightgreen'
  },
  font : {
    fontSize : 40 
  }
});