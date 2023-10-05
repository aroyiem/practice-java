package com.practice.collections.friendcircle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FriendCircle {

    public static void main(String[] args) {
        int[][] connection = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        List<List<Integer>> listOfCircles = new FriendCircle().getCircles(connection);
        for(List<Integer> circle: listOfCircles) {
            System.out.println(circle);
        }
    }
    List<List<Integer>> getCircles(int[][] connections) {
        List<List<Integer>> listOfCircles = new ArrayList<>();
        boolean[] visited = new boolean[connections.length];
        for(int row = 0; row < connections.length; row ++) {
            if(visited[row] == true ) {
                continue;
            }
            visited[row] = true;
            Queue<Integer> circularQueue = new LinkedList<>();
            circularQueue.add(row);

            List<Integer> listOfFriends = new ArrayList<>();

            while (!circularQueue.isEmpty()) {
                int userId = circularQueue.poll();
                listOfFriends.add(userId);
                for(int userFriend = 0; userFriend < connections[userId].length; userFriend++) {

                    if(connections[userId][userFriend] == 1 && !visited[userFriend]) {
                        circularQueue.add(userFriend);
                        visited[userFriend] = true;
                    }
                }
            }
            listOfCircles.add(listOfFriends);
        }

        return listOfCircles;
    }
}
