# Release Checklist

Use this checklist before publishing the public GitHub Release.

## Package Checks

1. Verify the zip contents.
2. Confirm the package contains the expected bridge jars:
   - `TDDUPJavaCombatBridge.jar`
   - `TTDUP_NPC_RenderBridge.jar`
3. Confirm the package contains install and uninstall helpers.
4. Confirm the package contains user-facing docs.
5. Confirm there are no Steam credentials, GitHub tokens, personal files, private notes, or local machine paths that should not be public.
6. Confirm there are no auto-downloaders, telemetry hooks, or background-service installers.

## Repository Checks

1. Generate SHA256 checksums for the release zip.
2. Update `SHA256SUMS.txt`.
3. Update `VERSION.txt` if the version changed.
4. Commit the docs and release-management files.
5. Push to GitHub.

## GitHub Pages

1. Open the repository settings on GitHub.
2. Go to Pages.
3. Set the source to the `main` branch.
4. Set the folder to `/docs`.
5. Save.
6. Wait for GitHub Pages to publish.
7. Open the published Pages URL and confirm the install, uninstall, troubleshooting, security, and Workshop pages display correctly.

## GitHub Release

1. Draft a new GitHub Release.
2. Tag it:

```text
v0.1.36-required
```

3. Use a clear title, such as:

```text
TDDUP Java Bridge 0.1.36g - Required External Bridge
```

4. Upload this release asset:

```text
TDDUP_JavaBridge_GitHubRelease_0.1.36g_FIXED_CleanInstallUninstall.zip
```

5. Include the checksum from `SHA256SUMS.txt` in the release notes.
6. Publish the release.
7. Copy the final GitHub Release URL.
8. Replace `REPLACE_WITH_YOUR_GITHUB_RELEASE_URL` in the Steam Workshop description text.
9. Update the Steam Workshop description.

## Final Smoke Check

1. Confirm the Steam Workshop text says the external Java Bridge is required.
2. Confirm the docs do not say the Workshop item works by itself.
3. Confirm the GitHub Release asset downloads correctly.
4. Confirm the release zip checksum matches `SHA256SUMS.txt`.
