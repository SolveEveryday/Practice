package pro_42888

class Solution2 {

    fun solution(record: Array<String>): Array<String> {

        val map = mutableMapOf<String, String>()
        val answer = ArrayList<String>()

        for (r in record) {
            val split = r.split(" ")

            when (split[0]) {
                "Enter", "Change" -> map += split[1] to split[2]
            }
        }

        for (r in record) {
            val split = r.split(" ")

            when (split[0]) {
                "Enter" -> answer.add("${map[split[1]]}님이 들어왔습니다.")
                "Leave" -> answer.add("${map[split[1]]}님이 나갔습니다.")
            }
        }

        return answer.toTypedArray()
    }
}