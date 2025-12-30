import { Text, View, Button, Alert } from 'react-native';

export default function App() {
  return (
    <View style={{ backgroundColor : 'plum', flex : 1, padding : 60 }}>
      <View style={{ marginBottom : 20 }}>
        <Button title="Show Alert1" onPress={() => Alert.alert('제목')} />
      </View>
      <View style={{ marginBottom : 20 }}>
        <Button title="Show Alert2" onPress={() => Alert.alert('제목', '내용입니다.')} />  
      </View>
      <View>
        <Button 
          title="Show Alert3" 
          onPress={() => 
            Alert.alert('제목', '내용입니다.', [
              {
                text : 'cancel',
                onPress : () => console.log('Cancel Press')
              },
              {
                text : 'ok',
                onPress : () => console.log('ok Press') 
              }
            ])
          } />
      </View>
    </View>
  );
}