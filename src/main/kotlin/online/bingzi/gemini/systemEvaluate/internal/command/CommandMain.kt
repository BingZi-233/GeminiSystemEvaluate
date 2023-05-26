package online.bingzi.gemini.systemEvaluate.internal.command

import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.PermissionDefault
import taboolib.common.platform.command.mainCommand
import taboolib.expansion.createHelper

@CommandHeader(
    name = "GeminiSystemEvaluate",
    permission = "gemini.system.evaluate.command",
    permissionDefault = PermissionDefault.OP
)
object CommandMain {
    @CommandBody(
        aliases = ["help"],
        permission = "gemini.system.evaluate.command.help",
        permissionDefault = PermissionDefault.OP
    )
    val main = mainCommand {
        createHelper()
    }
}