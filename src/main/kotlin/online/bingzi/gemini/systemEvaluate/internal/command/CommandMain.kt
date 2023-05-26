package online.bingzi.gemini.systemEvaluate.internal.command

import taboolib.common.platform.command.*
import taboolib.expansion.createHelper

@CommandHeader(
    name = "GeminiSystemEvaluate",
    permission = "gemini.systemEvaluate.command",
    permissionDefault = PermissionDefault.OP
)
object CommandMain {
    @CommandBody(
        aliases = ["help"],
        permission = "gemini.systemEvaluate.command.help",
        permissionDefault = PermissionDefault.OP
    )
    val main = mainCommand {
        createHelper()
    }

    @CommandBody(
        aliases = ["快速评估"],
        permission = "gemini.systemEvaluate.command.fastEvaluate",
        permissionDefault = PermissionDefault.OP
    )
    val fastEvaluate = subCommand {

    }

    @CommandBody(
        aliases = ["完整评估"],
        permission = "gemini.systemEvaluate.command.evaluate",
        permissionDefault = PermissionDefault.OP
    )
    val evaluate = subCommand {

    }

}