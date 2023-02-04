# Pageant (Silver)

**Category:** "Flood Fill"

**Year:** 2011

**Contest:** November

## Problem
Problem 1: Cow Beauty Pageant (Silver Level) [Brian Dean]

Hearing that the latest fashion trend was cows with three spots on their
hides, Farmer John has purchased an entire herd of three-spot cows.
Unfortunately, fashion trends tend to change quickly, and the most popular
current fashion is cows with only one spot!

FJ wants to make his herd more fashionable by painting each of his cows in
such a way that merges their three spots into one.  The hide of a cow is
represented by an N by M grid of characters like this:
```
................
..XXXX....XXX...
...XXXX....XX...
.XXXX......XXX..
........XXXXX...
..XXX....XXX....
```

Here, each 'X' denotes part of a spot.  Two 'X's belong to the same spot if
they are vertically or horizontally adjacent (diagonally adjacent does not
count), so the figure above has exactly three spots.  All of the cows in
FJ's herd have exactly three spots.

FJ wants to use as little paint as possible to merge the three spots into
one.  In the example above, he can do this by painting only four
additional characters with 'X's (the new characters are marked with '*'s
below to make them easier to see).
```
................
..XXXX....XXX...
...XXXX*...XX...
.XXXX..**..XXX..
...*....XXXXX...
..XXX....XXX....
```

Please help FJ determine the minimum number of new 'X's he must paint in
order to merge three spots into one large spot.

PROBLEM NAME: pageant

INPUT FORMAT:

* Line 1: Two space-separated integers, N and M (1 <= N,M <= 50).

* Lines 2..1+N: Each line contains a length-M string of 'X's and '.'
  specifying one row of the cow hide pattern.

SAMPLE INPUT (file pageant.in):

6 16
```
................
..XXXX....XXX...
...XXXX....XX...
.XXXX......XXX..
........XXXXX...
..XXX....XXX....
```


INPUT DETAILS:

The pattern in the input shows a cow hide with three distinct spots.

OUTPUT FORMAT:

* Line 1: The minimum number of new 'X's that must be added to the
  input pattern in order to obtain one single spot.

SAMPLE OUTPUT (file pageant.out):

4

OUTPUT DETAILS:

Four 'X's suffice to join the three spots into one.

## Solution
Solution Notes: We first use a recursive "floodfill" to label the characters in the three different spots with 1s, 2s, and 3s (in the process, we may also want to make a list of the locations of the characters in each spot). Next, we need to figure out the optimal way to join the three spots together. There are two possible ways to do this, and we must try both and take whichever yields the best solution: (1) pick one character, and draw shortest paths from this character outward to each of the three spots, or (2) find the shortest paths joining spots 1+2, 1+3, and 2+3, and take the smallest two of these. Here, a "shortest path" means a path whose "Manhattan" length (sum of absolute differences in coordinates) in smallest. There are several ways we can test all solutions of types (1) and (2) efficiently. Since the grid size is small enough, we can actually get away with more or less brute-force enumeration and still run in time; for example, we can loop over every pair of characters (2500^2 choices), in order to check all the shortest path distances we need. If the grid was much larger, we would probably need to use a breadth-first search in both cases to reduce the total shortest path computation time to linear in the total size of the grid, rather than quadratic in the size of the grid.


```cpp
#include <stdio.h>
#include <stdlib.h>
char cow[50][50];
int N, M, spots[3][2500][2], counts[3];

void mark_spot(int a, int b, int num) {
if(a<0 || b<0 || a==N || b==M || cow[a][b]!='X') return;
cow[a][b] = 'V';
spots[num][counts[num]][0] = a;
spots[num][counts[num]++][1] = b;
mark_spot(a-1, b, num);
mark_spot(a+1, b, num);
mark_spot(a, b-1, num);
mark_spot(a, b+1, num);
}

int l1_dist(int a1, int b1, int a2, int b2) {
return abs(a1-a2)+abs(b1-b2);
}

int try_point(int a, int b) {
if(cow[a][b]=='V') return 1000;
int i, j, ans = 0;
for(i=0; i<3; i++) {
int min = 101;
for(j=0; j<counts[i]; j++) {
int t = l1_dist(spots[i][j][0], spots[i][j][1], a, b)-1;
if(t<min) min = t;
}
ans+=min;
}
return ans+1;
}

int main() {
freopen("pageant.in", "r", stdin); freopen("pageant.out", "w", stdout);
scanf("%d %d", &N, &M);
int i, min = 301, j, num_spots = 0, mins[3], k;

for(i=0; i<N; i++)
scanf("%s", cow[i]);

for(i=0; i<N; i++)
for(j=0; j<M; j++)
if(cow[i][j]=='X')
mark_spot(i,j,num_spots++);

for(i=0; i<N; i++)
for(j=0; j<M; j++) {
int t = try_point(i,j);
if(t<min) min = t;
}

for(i=0; i<3; i++) {
mins[i]=101;
for(j=0; j<counts[i]; j++)
for(k=0; k<counts[(i+1)%3]; k++) {
int t = l1_dist(spots[i][j][0], spots[i][j][1], spots[(i+1)%3][k][0], spots[(i+1)%3][k][1])-1;
if(t<mins[i]) mins[i] = t;
}
}

for(i=0; i<3; i++)
if(mins[i]+mins[(i+1)%3]<min)
min = mins[i]+mins[(i+1)%3];

printf("%d\n", min);

return 0;
}
```