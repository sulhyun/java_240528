import React, {useState} from 'react';
import Greeting from './components/Greeting';
import Box from './components/Box';
import Count from './components/Count';
import { Button, StyleSheet, View } from 'react-native';

const App = () => {
  const [count, setCount] = useState(0);

  
  const up = () => {
    setCount(prev => prev + 1);
  }
  const down = () => {
    setCount(prev => prev - 1);
  }
  
  const move = (num) => {
    setCount(prev => prev + num);
  }
  return (
    <>  
      <View style={styles.full}>
        <Count count={count} up={up} down={down} />
      </View>
    </>
  );
};

export default App;

const styles = StyleSheet.create({
  full: {
    flex: 1,
  }
})