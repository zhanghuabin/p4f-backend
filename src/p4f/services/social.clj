(ns p4f.services.social)



(defn roll
  "摇骰子，取值范围在0~1之间"
  []
  (rand))

(defn vote
  "针对某个主题投票，如果所选项非法，则返回错误标记"
  [{:keys [topic chosen]}]
  ())
