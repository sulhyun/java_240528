import { StyleSheet, View } from "react-native";
import WriteHeader from "../components/WriteHeader";
import { SafeAreaView } from "react-native-safe-area-context";

function WriteScreen() {
  return(
    <SafeAreaView>
      <View style={styles.block}>
        <WriteHeader />
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  block: {},
});

export default WriteScreen;