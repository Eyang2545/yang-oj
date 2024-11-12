package com.eyang.yangojbackendjudgeservice.judge;

import com.eyang.yangojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.eyang.yangojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.eyang.yangojbackendjudgeservice.judge.strategy.JudgeContext;
import com.eyang.yangojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.eyang.yangojbackendmodel.model.codesandbox.JudgeInfo;
import com.eyang.yangojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
