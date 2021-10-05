package org.jellyfin.androidtv.di

import org.jellyfin.androidtv.preference.*
import org.jellyfin.sdk.api.operations.DisplayPreferencesApi
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val preferenceModule = module {
	single { PreferencesRepository(get(userApiClient), get(), get()) }

	single { LiveTvPreferences(DisplayPreferencesApi(get(userApiClient))) }
	single { UserSettingPreferences(DisplayPreferencesApi(get(userApiClient))) }
	single { AuthenticationPreferences(androidApplication()) }
	single { UserPreferences(androidApplication()) }
	single { SystemPreferences(androidApplication()) }
}
