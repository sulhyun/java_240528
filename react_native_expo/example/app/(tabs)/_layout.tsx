import { Ionicons } from "@expo/vector-icons";
import { Tabs } from "expo-router";

export default function TabLayout() {
  return(
    <Tabs screenOptions={{ headerShown: false}}>
      <Tabs.Screen 
        name="(todo)"
        options={{
          tabBarLabel: () => null,
          tabBarIcon: ({ focused }) => (
            <Ionicons
              name="list"
              size={24}
              color={focused ? "black" : "gray"}
            />
          )
        }}
      />
      <Tabs.Screen 
        name="(community)"
        options={{
          tabBarLabel: () => null,
          tabBarIcon: ({ focused }) => (
            <Ionicons
              name="bookmarks"
              size={24}
              color={focused ? "black" : "gray"}
            />
          )
        }}
      />
    </Tabs>
  )
}