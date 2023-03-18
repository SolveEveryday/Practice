#include <vector>
#include <iostream>
#include <map>
#include <string>
#include <algorithm>
using namespace std;

map<string,int> players;

string solution(vector<string> participant, vector<string> completion) 
{
 
    string answer = "";
    
    for(auto& name : participant) {
        players[name]++;
    }

    for(auto& name : completion) {
        players[name]--;
    }

    for(auto& name : participant) {
        if(players[name] != 0) answer = name;
    }
    return answer;
}