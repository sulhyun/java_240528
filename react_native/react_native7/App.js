import { View, StatusBar, ActivityIndicator } from 'react-native';

export default function App() {
  return (
    <View style={{ backgroundColor : 'plum', flex : 1, padding : 60 }}>
      <StatusBar backgroundColor={'lightblue'} barStyle={'dark-content'} />
      <ActivityIndicator />
      <ActivityIndicator size={'large'} />
      <ActivityIndicator size={'large'} color={'lightgreen'} />
      <ActivityIndicator animating={false} />
    </View>
  );
}