class Solution {
  fun solution(record: Array<String>): Array<String> {
      val users = Users()
      val chatLogs = ChatLogs()
      
      for (log in record) {
          val splitedLog = log.split(" ")
          val (command, userId, nickname) = Triple(splitedLog[0], splitedLog[1], splitedLog.getOrNull(2) ?: null)
          
          val user = users.getOrCreateOrUpdate(userId, nickname)
          if (command == "Change") continue
          
          chatLogs.add(ChatLog(user, command))
      }
      
      return chatLogs.toStringArray()
  }
}

class ChatLogs {
  val chatLogs = mutableListOf<ChatLog>()
  
  fun add(chatLog: ChatLog) = chatLogs.add(chatLog)
  
  fun toStringArray(): Array<String> {
      val strLogs = mutableListOf<String>()
      
      for (chatLog in chatLogs) {
          val (user, type) = chatLog
          
          val strLog = when(type) {
              "Enter" -> "${user.nickname}님이 들어왔습니다."
              else -> "${user.nickname}님이 나갔습니다."
          }
          
          strLogs.add(strLog)
      }
      
      return strLogs.toTypedArray()
  }
}

data class ChatLog(val user: User, val type: String)

class Users {
  val userMap = mutableMapOf<String, User>()
  
  fun getOrCreateOrUpdate(userId:String, nickname: String?): User {
      val user = userMap.getOrPut(userId) { User(nickname!!) }
      if (nickname == null) return user
      
      if (user.nickname != nickname) {
          user.nickname = nickname
      }
      return user
  }
}

data class User(var nickname: String)
