import { Link } from "expo-router";
import { Text, TouchableOpacity, View } from "react-native";

export default function Index() {
  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Link href="/postList" asChild>
        <TouchableOpacity>
          <Text>커뮤니티</Text>
        </TouchableOpacity>
      </Link>
    </View>
  );
}
