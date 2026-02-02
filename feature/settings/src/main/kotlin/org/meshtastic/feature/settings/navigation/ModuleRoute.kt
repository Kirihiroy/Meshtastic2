/*
 * Copyright (c) 2025 Meshtastic LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.meshtastic.feature.settings.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ForwardToInbox
import androidx.compose.material.icons.automirrored.rounded.Message
import androidx.compose.material.icons.automirrored.rounded.VolumeUp
import androidx.compose.material.icons.rounded.CloudQueue
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.NotificationsActive
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.PermScanWifi
import androidx.compose.material.icons.rounded.QueryStats
import androidx.compose.material.icons.rounded.Sensors
import androidx.compose.material.icons.rounded.SettingsRemote
import androidx.compose.material.icons.rounded.Speed
import androidx.compose.material.icons.rounded.Usb
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource
import org.meshtastic.core.navigation.Route
import org.meshtastic.core.navigation.SettingsRoutes
import org.meshtastic.core.strings.Res
import org.meshtastic.core.strings.ambient_lighting
import org.meshtastic.core.strings.audio
import org.meshtastic.core.strings.canned_message
import org.meshtastic.core.strings.detection_sensor
import org.meshtastic.core.strings.external_notification
import org.meshtastic.core.strings.mqtt
import org.meshtastic.core.strings.neighbor_info
import org.meshtastic.core.strings.paxcounter
import org.meshtastic.core.strings.range_test
import org.meshtastic.core.strings.remote_hardware
import org.meshtastic.core.strings.serial
import org.meshtastic.core.strings.store_forward
import org.meshtastic.core.strings.telemetry
import org.meshtastic.proto.AdminProtos
import org.meshtastic.proto.MeshProtos.DeviceMetadata

enum class ModuleRoute(val title: StringResource, val route: Route, val icon: ImageVector?, val type: Int = 0) {
    MQTT(
        Res.string.mqtt,
        SettingsRoutes.MQTT,
        Icons.Rounded.CloudQueue,
        AdminProtos.AdminMessage.ModuleConfigType.MQTT_CONFIG_VALUE,
    ),
    SERIAL(
        Res.string.serial,
        SettingsRoutes.Serial,
        Icons.Rounded.Usb,
        AdminProtos.AdminMessage.ModuleConfigType.SERIAL_CONFIG_VALUE,
    ),
    EXT_NOTIFICATION(
        Res.string.external_notification,
        SettingsRoutes.ExtNotification,
        Icons.Rounded.NotificationsActive,
        AdminProtos.AdminMessage.ModuleConfigType.EXTNOTIF_CONFIG_VALUE,
    ),
    STORE_FORWARD(
        Res.string.store_forward,
        SettingsRoutes.StoreForward,
        Icons.AutoMirrored.Rounded.ForwardToInbox,
        AdminProtos.AdminMessage.ModuleConfigType.STOREFORWARD_CONFIG_VALUE,
    ),
    RANGE_TEST(
        Res.string.range_test,
        SettingsRoutes.RangeTest,
        Icons.Rounded.Speed,
        AdminProtos.AdminMessage.ModuleConfigType.RANGETEST_CONFIG_VALUE,
    ),
    TELEMETRY(
        Res.string.telemetry,
        SettingsRoutes.Telemetry,
        Icons.Rounded.QueryStats,
        AdminProtos.AdminMessage.ModuleConfigType.TELEMETRY_CONFIG_VALUE,
    ),
    CANNED_MESSAGE(
        Res.string.canned_message,
        SettingsRoutes.CannedMessage,
        Icons.AutoMirrored.Rounded.Message,
        AdminProtos.AdminMessage.ModuleConfigType.CANNEDMSG_CONFIG_VALUE,
    ),
    AUDIO(
        Res.string.audio,
        SettingsRoutes.Audio,
        Icons.AutoMirrored.Rounded.VolumeUp,
        AdminProtos.AdminMessage.ModuleConfigType.AUDIO_CONFIG_VALUE,
    ),
    REMOTE_HARDWARE(
        Res.string.remote_hardware,
        SettingsRoutes.RemoteHardware,
        Icons.Rounded.SettingsRemote,
        AdminProtos.AdminMessage.ModuleConfigType.REMOTEHARDWARE_CONFIG_VALUE,
    ),
    NEIGHBOR_INFO(
        Res.string.neighbor_info,
        SettingsRoutes.NeighborInfo,
        Icons.Rounded.People,
        AdminProtos.AdminMessage.ModuleConfigType.NEIGHBORINFO_CONFIG_VALUE,
    ),
    AMBIENT_LIGHTING(
        Res.string.ambient_lighting,
        SettingsRoutes.AmbientLighting,
        Icons.Rounded.LightMode,
        AdminProtos.AdminMessage.ModuleConfigType.AMBIENTLIGHTING_CONFIG_VALUE,
    ),
    DETECTION_SENSOR(
        Res.string.detection_sensor,
        SettingsRoutes.DetectionSensor,
        Icons.Rounded.Sensors,
        AdminProtos.AdminMessage.ModuleConfigType.DETECTIONSENSOR_CONFIG_VALUE,
    ),
    PAXCOUNTER(
        Res.string.paxcounter,
        SettingsRoutes.Paxcounter,
        Icons.Rounded.PermScanWifi,
        AdminProtos.AdminMessage.ModuleConfigType.PAXCOUNTER_CONFIG_VALUE,
    ),
    ;

    val bitfield: Int
        get() = 1 shl ordinal

    companion object {
        fun filterExcludedFrom(metadata: DeviceMetadata?): List<ModuleRoute> = entries.filter {
            when (metadata) {
                null -> true // Include all routes if metadata is null
                else -> metadata.excludedModules and it.bitfield == 0
            }
        }
    }
}
