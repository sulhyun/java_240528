import React from "react";
import { FlatList, StyleSheet, View } from "react-native";
import FeedListItem from "./FeedListItem";

function FeedList({logs, onScrolledToBottom}) {
  const onScroll = (e) => {
    const {contentSize, layoutMeasurement, contentOffset} = e.nativeEvent;
    const distanceFromBottom = contentSize.height - layoutMeasurement.height - contentOffset.y;

    if(distanceFromBottom < 72) {
      onScrolledToBottom(true);
    } else {
      onScrolledToBottom(false);
    }
  };

  return(
    <FlatList 
      style={styles.block}
      data={logs}
      renderItem={renderItem}
      keyExtractor={(item) => item.id}
      ItemSeparatorComponent={() => <View style={styles.separator} />}
      onScroll={onScroll}
    />
  );
};

const renderItem = ({item}) => (
  <FeedListItem log={item} />
);

const styles = StyleSheet.create({
  block: {
    flex: 1,
  },
  separator: {
    backgroundColor: '#e0e0e0',
    height: 1,
    width: '100%',
  },
})

export default FeedList;