import { StyleSheet, Text, View } from 'react-native';

export default function Index() {
  return (
    <View style={ styles.container }>
      <Text>Edit app/post.tsx to edit this screen.</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container : { flex: 1, justifyContent: "center", alignItems: "center", backgroundColor: "white" }
});