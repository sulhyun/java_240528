import { useState } from 'react';
import { View, Text, Button, Modal } from 'react-native';

export default function App() {
  const [ isModal, setModal ] = useState(false);
  return (
    <View style={{ backgroundColor : 'plum', flex : 1, padding : 60 }}>
      <Text>Modal Content</Text>
      <Button title='Show Modal' onPress={() => setModal(true)} />
      <Modal visible={isModal} onRequestClose={() => setModal(false)} animationType='slide'>
        <View style={{ backgroundColor : 'black', flex : 1, padding : 60 }}>
          <Text style={{ color : 'white' }}>This is Modal</Text>
          <Button title='Close Modal' onPress={() => setModal(false)} />
        </View>
      </Modal>
    </View>
  );
}

