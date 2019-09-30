package com.danefinlay.ttsutil

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.net.Uri

// IntentService actions.
private const val ACTION_READ_TEXT = "${APP_NAME}.action.READ_TEXT"
private const val ACTION_EDIT_READ_TEXT = "${APP_NAME}.action.EDIT_READ_TEXT"
private const val ACTION_READ_FILE = "${APP_NAME}.action.READ_FILE"

// Parameter constants (for Intent extras).
private const val EXTRA_TEXT = "${APP_NAME}.extra.TEXT"
private const val EXTRA_FILE_URI = "${APP_NAME}.extra.FILE_URI"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
class SpeakerIntentService : IntentService("SpeakerIntentService") {

    private val myApplication: ApplicationEx
        get() = application as ApplicationEx

    private val speaker: Speaker?
        get() = myApplication.speaker

    override fun onHandleIntent(intent: Intent?) {
        val text = intent?.getStringExtra(EXTRA_TEXT) ?: ""
        when (intent?.action) {
            ACTION_READ_TEXT -> handleActionReadText(text)
            ACTION_EDIT_READ_TEXT -> handleActionEditReadText(text)
            ACTION_READ_FILE -> {
                val uri = intent.getParcelableExtra<Uri>(EXTRA_FILE_URI)
                handleActionReadFile(uri)
            }
        }
    }

    /**
     * Handle action ReadText in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionReadText(text: String) {
        TODO("Handle action ReadText")
    }

    /**
     * Handle action EditReadText in the provided background thread with the
     * provided parameters.
     */
    private fun handleActionEditReadText(text: String) {
        TODO("Handle action EditReadText")
    }

    /**
     * Handle action ReadFile in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionReadFile(text: Uri) {
        TODO("Handle action ReadFile")
    }

    companion object {
        /**
         * Starts this service to perform action ReadText. If the service is already
         * performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun startActionReadText(ctx: Context, text: String) {
            val intent = Intent(ctx, SpeakerIntentService::class.java).apply {
                action = ACTION_READ_TEXT
                putExtra(EXTRA_TEXT, text)
            }
            ctx.startService(intent)
        }

        /**
         * Starts this service to perform action EditReadText. If the service is
         * already performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun startActionEditReadText(ctx: Context, text: String) {
            val intent = Intent(ctx, SpeakerIntentService::class.java).apply {
                action = ACTION_EDIT_READ_TEXT
                putExtra(EXTRA_TEXT, text)
            }
            ctx.startService(intent)
        }

        /**
         * Starts this service to perform action ReadFile. If the service is already
         * performing a task this action will be queued.
         *
         * @see IntentService
         */
        @JvmStatic
        fun startActionReadFile(ctx: Context, fileUri: Uri) {
            val intent = Intent(ctx, SpeakerIntentService::class.java).apply {
                action = ACTION_READ_FILE
                putExtra(EXTRA_FILE_URI, fileUri)
            }
            ctx.startService(intent)
        }
    }
}